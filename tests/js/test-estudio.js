/**
 * Mezcla un array usando el algoritmo Fisher-Yates
 * Crea una copia del array original para no modificar el original
 */
function shuffleArray(array) {
    const shuffled = [...array]; // Crear copia del array
    for (let i = shuffled.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [shuffled[i], shuffled[j]] = [shuffled[j], shuffled[i]]; // Intercambiar elementos
    }
    return shuffled;
}

/**
 * Clase que gestiona el sistema de tests en modo estudio
 * Muestra feedback inmediato al responder cada pregunta
 */
class TestManagerEstudio {
    constructor(questions) {
        // Validar que hay preguntas
        if (!questions || questions.length === 0) {
            throw new Error('No hay preguntas disponibles para el test');
        }
        
        // Mezclar las preguntas cada vez que se crea una instancia
        this.questions = shuffleArray(questions);
        this.currentQuestionIndex = 0;
        this.answers = {}; // Guarda las respuestas del usuario: {indicePregunta: indiceRespuesta}
        this.startTime = null; // Timestamp cuando inicia el test
        this.endTime = null; // Timestamp cuando termina el test
    }

    /**
     * Inicia el test guardando el tiempo de inicio y cargando la primera pregunta
     */
    start() {
        this.startTime = Date.now();
        this.loadQuestion();
        this.updateProgress();
    }

    /**
     * Carga la pregunta actual en la interfaz
     * Limpia las opciones anteriores y crea nuevas opciones para la pregunta actual
     */
    loadQuestion() {
        // Validar que el indice esta en rango
        if (this.currentQuestionIndex < 0 || this.currentQuestionIndex >= this.questions.length) {
            console.error('Indice de pregunta fuera de rango');
            return;
        }
        
        const question = this.questions[this.currentQuestionIndex];
        
        // Validar estructura de la pregunta
        if (!question || !question.question || !question.options || question.options.length < 2) {
            console.error('Pregunta con estructura invalida: debe tener al menos 2 opciones');
            return;
        }
        
        // Validar que el indice correcto esta en rango
        if (question.correct < 0 || question.correct >= question.options.length) {
            console.error('Indice de respuesta correcta fuera de rango');
            return;
        }
        
        const questionCard = document.getElementById('question-card');
        
        // Si no existe el elemento, salir de la funcion
        if (!questionCard) return;

        // Ocultar feedback anterior
        const feedbackArea = document.getElementById('feedback-area');
        if (feedbackArea) {
            feedbackArea.style.display = 'none';
            feedbackArea.innerHTML = '';
        }

        // Limpiar las opciones de la pregunta anterior
        const optionsList = document.getElementById('options-list');
        if (optionsList) {
            optionsList.innerHTML = '';
        }

        // Actualizar el numero de pregunta (ej: "Pregunta 1 de 15")
        const questionNumber = document.getElementById('question-number');
        if (questionNumber) {
            questionNumber.textContent = `Pregunta ${this.currentQuestionIndex + 1} de ${this.questions.length}`;
        }

        // Mostrar el texto de la pregunta
        const questionText = document.getElementById('question-text');
        if (questionText) {
            // Escapar el texto de la pregunta para seguridad
            let html = this.escapeHtml(question.question);
            
            // Si la pregunta tiene codigo de ejemplo, agregarlo en un bloque
            if (question.code) {
                html += `<div class="code-block">${this.escapeHtml(question.code)}</div>`;
            }
            
            questionText.innerHTML = html;
        }

        // Verificar si ya se respondio esta pregunta para mostrar el feedback
        const alreadyAnswered = this.answers[this.currentQuestionIndex] !== undefined;
        const userAnswer = this.answers[this.currentQuestionIndex];
        const isCorrect = alreadyAnswered && userAnswer === question.correct;

        // Crear las opciones de respuesta dinamicamente
        if (optionsList) {
            question.options.forEach((option, index) => {
                // Crear elemento li para cada opcion
                const li = document.createElement('li');
                li.className = 'option-item';
                
                // Crear label clickeable para la opcion
                const label = document.createElement('label');
                label.className = 'option-label';
                label.setAttribute('role', 'radio');
                label.setAttribute('aria-checked', userAnswer === index ? 'true' : 'false');
                label.setAttribute('tabindex', '0');
                
                // Si esta opcion ya fue seleccionada antes, marcarla como seleccionada
                if (userAnswer === index) {
                    label.classList.add('selected');
                }
                
                // Si ya se respondio, marcar visualmente la respuesta correcta e incorrecta
                if (alreadyAnswered) {
                    if (index === question.correct) {
                        label.classList.add('correct-answer');
                    } else if (index === userAnswer && !isCorrect) {
                        label.classList.add('incorrect-answer');
                    }
                    // Deshabilitar todas las opciones una vez respondida
                    label.style.pointerEvents = 'none';
                    label.style.opacity = index === question.correct || index === userAnswer ? '1' : '0.6';
                }
                
                // Crear radio button para la opcion
                const radio = document.createElement('input');
                radio.type = 'radio';
                radio.name = 'answer';
                radio.value = index;
                radio.className = 'option-radio';
                radio.id = `option-${this.currentQuestionIndex}-${index}`;
                radio.checked = userAnswer === index;
                radio.disabled = alreadyAnswered; // Deshabilitar si ya se respondio
                // Escapar el texto de la opcion para el aria-label
                radio.setAttribute('aria-label', `Opción ${index + 1}: ${this.escapeHtml(option)}`);
                
                // Cuando se selecciona esta opcion, guardar la respuesta y mostrar feedback
                const selectThisOption = () => {
                    if (alreadyAnswered) return; // No permitir cambiar respuesta
                    
                    this.selectAnswer(index);
                    // Quitar la clase selected de todas las opciones
                    document.querySelectorAll('.option-label').forEach(l => {
                        l.classList.remove('selected');
                        l.setAttribute('aria-checked', 'false');
                    });
                    // Agregar selected a la opcion elegida
                    label.classList.add('selected');
                    label.setAttribute('aria-checked', 'true');
                    
                    // Mostrar feedback inmediato
                    this.showFeedback(question, index);
                };
                
                radio.addEventListener('change', selectThisOption);
                
                // Permitir seleccionar con Enter o Espacio en el label
                label.addEventListener('keydown', (e) => {
                    if (alreadyAnswered) return;
                    if (e.key === 'Enter' || e.key === ' ') {
                        e.preventDefault();
                        radio.checked = true;
                        selectThisOption();
                    }
                });
                
                // Crear span con el texto de la opcion
                const span = document.createElement('span');
                span.className = 'option-text';
                span.textContent = option;
                
                // Ensamblar los elementos: label contiene radio y span, li contiene label
                label.appendChild(radio);
                label.appendChild(span);
                li.appendChild(label);
                optionsList.appendChild(li);
            });
        }

        // Si ya se respondio, mostrar el feedback
        if (alreadyAnswered) {
            this.showFeedback(question, userAnswer);
        }

        // Actualizar el estado de los botones de navegacion
        this.updateNavigationButtons();
    }

    /**
     * Muestra feedback inmediato cuando el usuario responde
     * Si es correcta, solo muestra confirmacion
     * Si es incorrecta, muestra explicacion y respuesta correcta
     */
    showFeedback(question, userAnswerIndex) {
        const feedbackArea = document.getElementById('feedback-area');
        if (!feedbackArea) return;

        // Validar que question.correct este en rango antes de acceder
        if (question.correct < 0 || question.correct >= question.options.length) {
            console.error('Indice de respuesta correcta fuera de rango en showFeedback');
            return;
        }

        const isCorrect = userAnswerIndex === question.correct;
        
        // Marcar visualmente las opciones correctas e incorrectas
        document.querySelectorAll('.option-label').forEach((label, index) => {
            const radio = label.querySelector('input[type="radio"]');
            if (radio) {
                radio.disabled = true;
                label.style.pointerEvents = 'none';
                
                if (index === question.correct) {
                    label.classList.add('correct-answer');
                } else if (index === userAnswerIndex && !isCorrect) {
                    label.classList.add('incorrect-answer');
                } else {
                    label.style.opacity = '0.6';
                }
            }
        });

        let feedbackHTML = '';
        
        if (isCorrect) {
            // Respuesta correcta: solo mostrar confirmacion
            feedbackHTML = `
                <div class="feedback-correct">
                    <strong>Correcto!</strong>
                </div>
            `;
        } else {
            // Respuesta incorrecta: mostrar explicacion y respuesta correcta
            // Validar acceso a question.options[question.correct]
            const correctAnswerText = question.options && question.options[question.correct] 
                ? question.options[question.correct] 
                : 'Error: respuesta correcta no disponible';
            feedbackHTML = `
                <div class="feedback-incorrect">
                    <strong>Incorrecto</strong>
                    <p style="margin-top: 10px;">
                        <strong>Respuesta correcta:</strong> ${this.escapeHtml(correctAnswerText)}
                    </p>
                    ${question.explanation ? `
                        <p style="margin-top: 10px;">
                            <strong>Explicacion:</strong> ${this.escapeHtml(question.explanation)}
                        </p>
                    ` : ''}
                </div>
            `;
        }

        feedbackArea.innerHTML = feedbackHTML;
        feedbackArea.style.display = 'block';
        
        // Actualizar progreso
        this.updateProgress();
    }

    /**
     * Guarda la respuesta seleccionada por el usuario para la pregunta actual
     */
    selectAnswer(answerIndex) {
        this.answers[this.currentQuestionIndex] = answerIndex;
    }

    /**
     * Avanza a la siguiente pregunta si no estamos en la ultima
     */
    nextQuestion() {
        if (this.currentQuestionIndex < this.questions.length - 1) {
            this.currentQuestionIndex++;
            this.loadQuestion();
        }
    }

    /**
     * Retrocede a la pregunta anterior si no estamos en la primera
     */
    previousQuestion() {
        if (this.currentQuestionIndex > 0) {
            this.currentQuestionIndex--;
            this.loadQuestion();
        }
    }

    /**
     * Calcula el numero de respuestas correctas basandose en las respuestas actuales
     */
    calculateCorrectCount() {
        let count = 0;
        this.questions.forEach((question, index) => {
            const userAnswer = this.answers[index];
            if (userAnswer !== undefined && userAnswer === question.correct) {
                count++;
            }
        });
        return count;
    }

    /**
     * Actualiza la barra de progreso mostrando cuantas preguntas se han respondido
     */
    updateProgress() {
        const progressFill = document.getElementById('progress-fill');
        const progressText = document.getElementById('progress-text');
        const progressContainer = document.querySelector('.test-progress');
        
        const answered = Object.keys(this.answers).length;
        const progress = (answered / this.questions.length) * 100;
        const correctCount = this.calculateCorrectCount();
        
        if (progressFill) {
            progressFill.style.width = `${progress}%`;
        }
        
        if (progressText) {
            progressText.textContent = `${answered} de ${this.questions.length} preguntas respondidas (${correctCount} correctas)`;
        }
        
        // Actualizar atributos ARIA para accesibilidad
        if (progressContainer) {
            progressContainer.setAttribute('aria-valuenow', answered);
            progressContainer.setAttribute('aria-valuemax', this.questions.length);
        }
    }

    /**
     * Actualiza el estado de los botones de navegacion
     * Deshabilita "Anterior" en la primera pregunta
     * Muestra "Siguiente" o "Ver Resumen" segun corresponda
     */
    updateNavigationButtons() {
        const btnPrev = document.getElementById('btn-prev');
        const btnNext = document.getElementById('btn-next');
        const btnSubmit = document.getElementById('btn-submit');
        
        // Deshabilitar boton anterior si estamos en la primera pregunta
        if (btnPrev) {
            btnPrev.disabled = this.currentQuestionIndex === 0;
        }
        
        // Ocultar "Siguiente" y mostrar "Ver Resumen" en la ultima pregunta
        if (btnNext) {
            btnNext.style.display = this.currentQuestionIndex === this.questions.length - 1 ? 'none' : 'block';
        }
        
        if (btnSubmit) {
            btnSubmit.style.display = this.currentQuestionIndex === this.questions.length - 1 ? 'block' : 'none';
        }
    }

    /**
     * Muestra el resumen final del test en modo estudio
     */
    submitTest() {
        this.endTime = Date.now();
        this.showSummary();
    }

    /**
     * Muestra un resumen final con estadisticas del test
     */
    showSummary() {
        // Ocultar el contenedor del test
        const testContainer = document.querySelector('.test-container');
        if (testContainer) {
            testContainer.style.display = 'none';
        }

        // Calcular estadisticas
        const correctCount = this.calculateCorrectCount();
        const percentage = this.questions.length > 0 ? Math.round((correctCount / this.questions.length) * 100) : 0;
        const totalSeconds = this.startTime && this.endTime ? Math.max(0, Math.round((this.endTime - this.startTime) / 1000)) : 0;
        const minutes = Math.floor(totalSeconds / 60);
        const seconds = totalSeconds % 60;
        
        let timeSpent;
        if (minutes > 0) {
            timeSpent = `${minutes} minuto${minutes > 1 ? 's' : ''} y ${seconds} segundo${seconds !== 1 ? 's' : ''}`;
        } else {
            timeSpent = `${seconds} segundo${seconds !== 1 ? 's' : ''}`;
        }

        // Determinar mensaje y color
        let message, color;
        if (percentage >= 80) {
            message = 'Excelente trabajo!';
            color = '#34a853';
        } else if (percentage >= 60) {
            message = 'Buen trabajo, pero puedes mejorar';
            color = '#fbbc04';
        } else {
            message = 'Sigue estudiando, lo conseguiras';
            color = '#ea4335';
        }

        const body = document.body;
        const summaryHTML = `
            <div class="container">
                <div class="results-container">
                    <div class="results-card">
                        <h2 style="color: ${color}; margin-bottom: 10px;">${message}</h2>
                        <div class="results-score" style="color: ${color};">${correctCount}/${this.questions.length}</div>
                        <div class="results-percentage">${percentage}% de aciertos</div>
                        <p style="color: var(--text-secondary); margin-bottom: 30px;">Tiempo empleado: ${timeSpent}</p>
                        <p style="color: var(--text-secondary); margin-bottom: 30px;">
                            En modo estudio recibiste feedback inmediato en cada pregunta. 
                            Prueba el modo examen para una experiencia mas realista.
                        </p>
                        
                        <button id="btn-export-pdf" class="btn-retry" style="background: var(--secondary-color); margin-bottom: 10px;">📄 Exportar PDF</button>
                        <a href="../../tests/javafx/test-javafx-estudio.html" class="btn-retry">Intentar de nuevo</a>
                        <a href="../../tests/javafx/test-javafx.html" class="btn-retry" style="background: var(--primary-color); margin-left: 10px;">Probar modo examen</a>
                        <a href="../../index.html" class="btn-retry" style="background: var(--text-secondary); margin-left: 10px;">Volver al inicio</a>
                    </div>
                </div>
            </div>
        `;

        body.innerHTML = summaryHTML;
        
        // Configurar boton de exportar PDF
        const btnExportPdf = document.getElementById('btn-export-pdf');
        if (btnExportPdf) {
            btnExportPdf.addEventListener('click', () => {
                this.exportToPDF(correctCount, this.questions.length, percentage, timeSpent);
            });
        }
    }
    
    /**
     * Exporta los resultados a PDF usando html2pdf.js
     */
    exportToPDF(correct, total, percentage, timeSpent) {
        // Verificar si html2pdf esta disponible
        if (typeof html2pdf === 'undefined') {
            alert('Error: La librería para exportar PDF no está cargada. Por favor, recarga la página.');
            return;
        }
        
        // Crear contenido HTML para el PDF
        let message, color;
        if (percentage >= 80) {
            message = 'Excelente trabajo!';
            color = '#34a853';
        } else if (percentage >= 60) {
            message = 'Buen trabajo, pero puedes mejorar';
            color = '#fbbc04';
        } else {
            message = 'Sigue estudiando, lo conseguirás';
            color = '#ea4335';
        }
        
        const pdfContent = `
            <div style="font-family: Arial, sans-serif; padding: 20px; max-width: 800px; margin: 0 auto;">
                <h1 style="color: ${color}; text-align: center; margin-bottom: 10px;">Resultados del Test (Modo Estudio)</h1>
                <h2 style="color: ${color}; text-align: center; margin-bottom: 20px;">${message}</h2>
                <div style="text-align: center; margin-bottom: 30px;">
                    <p style="font-size: 24px; font-weight: bold; color: ${color}; margin: 10px 0;">${correct}/${total} respuestas correctas</p>
                    <p style="font-size: 20px; color: #666; margin: 10px 0;">${percentage}% de aciertos</p>
                    <p style="color: #666; margin: 10px 0;">Tiempo empleado: ${timeSpent}</p>
                </div>
                <hr style="border: 1px solid #ddd; margin: 30px 0;">
                <p style="text-align: center; color: #666; font-style: italic; margin-bottom: 30px;">
                    En modo estudio recibiste feedback inmediato en cada pregunta.
                </p>
                <hr style="border: 1px solid #ddd; margin: 30px 0;">
                <p style="text-align: center; color: #999; font-size: 12px; margin-top: 30px;">
                    Generado el ${new Date().toLocaleDateString('es-ES', { year: 'numeric', month: 'long', day: 'numeric', hour: '2-digit', minute: '2-digit' })}
                </p>
            </div>
        `;
        
        // Crear elemento temporal para el PDF
        const element = document.createElement('div');
        element.innerHTML = pdfContent;
        document.body.appendChild(element);
        
        // Configuracion para el PDF
        const opt = {
            margin: [10, 10, 10, 10],
            filename: `resultados-test-estudio-${new Date().toISOString().split('T')[0]}.pdf`,
            image: { type: 'jpeg', quality: 0.98 },
            html2canvas: { scale: 2, useCORS: true },
            jsPDF: { unit: 'mm', format: 'a4', orientation: 'portrait' }
        };
        
        // Generar y descargar el PDF
        html2pdf().set(opt).from(element).save().then(() => {
            // Eliminar elemento temporal
            document.body.removeChild(element);
        }).catch((error) => {
            console.error('Error al generar PDF:', error);
            alert('Error al generar el PDF. Por favor, intenta de nuevo.');
            document.body.removeChild(element);
        });
    }

    /**
     * Escapa caracteres HTML para evitar inyeccion de codigo
     * Convierte texto plano en HTML seguro
     */
    escapeHtml(text) {
        // Manejar casos donde text sea null, undefined o no sea string
        if (text == null) {
            return '';
        }
        if (typeof text !== 'string') {
            text = String(text);
        }
        const div = document.createElement('div');
        div.textContent = text;
        return div.innerHTML;
    }
}

// Esperar a que el DOM este completamente cargado antes de inicializar
document.addEventListener('DOMContentLoaded', () => {
    // Solo inicializar si estamos en la pagina del test (tiene el elemento question-card)
    if (document.getElementById('question-card')) {
        // Validar que questions este definido y disponible
        if (typeof questions === 'undefined' || !questions) {
            console.error('Error: No se pudieron cargar las preguntas. Verifica que questions.js se haya cargado correctamente.');
            const questionCard = document.getElementById('question-card');
            if (questionCard) {
                questionCard.innerHTML = '<p style="color: red;">Error: No se pudieron cargar las preguntas del test.</p>';
            }
            return;
        }
        
        // Crear instancia del gestor de tests con las preguntas
        let testManager;
        try {
            testManager = new TestManagerEstudio(questions);
        } catch (error) {
            console.error('Error al inicializar el test:', error);
            const questionCard = document.getElementById('question-card');
            if (questionCard) {
                questionCard.innerHTML = `<p style="color: red;">Error al inicializar el test: ${error.message}</p>`;
            }
            return;
        }
        
        // Configurar event listeners para los botones de navegacion
        const btnNext = document.getElementById('btn-next');
        const btnPrev = document.getElementById('btn-prev');
        const btnSubmit = document.getElementById('btn-submit');
        const btnCancel = document.getElementById('btn-cancel');
        
        if (btnNext) {
            btnNext.addEventListener('click', () => {
                testManager.nextQuestion();
            });
        }
        
        if (btnPrev) {
            btnPrev.addEventListener('click', () => {
                testManager.previousQuestion();
            });
        }
        
        if (btnSubmit) {
            btnSubmit.addEventListener('click', () => {
                testManager.submitTest();
            });
        }
        
        // Boton cancelar: volver al menu principal con confirmacion
        if (btnCancel) {
            btnCancel.addEventListener('click', () => {
                const answered = Object.keys(testManager.answers).length;
                let message = '¿Estás seguro de que quieres cancelar el test?';
                if (answered > 0) {
                    message += `\n\nHas respondido ${answered} pregunta(s). Tu progreso se perderá.`;
                }
                if (confirm(message)) {
                    window.location.href = '../../index.html';
                }
            });
        }
        
        // Navegacion por teclado
        const handleKeydown = (e) => {
            // Verificar que testManager existe
            if (!testManager) return;
            // Solo si estamos en la pagina del test
            if (!document.getElementById('question-card')) return;
            
            // Evitar navegacion si estamos escribiendo en un input
            if (e.target.tagName === 'INPUT' || e.target.tagName === 'TEXTAREA') return;
            
            switch(e.key) {
                case 'ArrowLeft':
                    if (btnPrev && !btnPrev.disabled) {
                        e.preventDefault();
                        testManager.previousQuestion();
                    }
                    break;
                case 'ArrowRight':
                case 'Enter':
                    // Verificar si el boton siguiente existe y esta visible
                    if (btnNext && btnNext.offsetParent !== null) {
                        e.preventDefault();
                        testManager.nextQuestion();
                    } else if (btnSubmit && btnSubmit.offsetParent !== null) {
                        e.preventDefault();
                        testManager.submitTest();
                    }
                    break;
                case '1':
                case '2':
                case '3':
                case '4':
                    // Seleccionar opcion con numeros 1-4 solo si no esta respondida
                    const currentAnswer = testManager.answers[testManager.currentQuestionIndex];
                    if (currentAnswer === undefined) {
                        e.preventDefault();
                        const optionIndex = parseInt(e.key) - 1;
                        const radio = document.getElementById(`option-${testManager.currentQuestionIndex}-${optionIndex}`);
                        if (radio && !radio.disabled) {
                            radio.checked = true;
                            radio.dispatchEvent(new Event('change'));
                        }
                    }
                    break;
            }
        };
        
        document.addEventListener('keydown', handleKeydown);
        
        // Iniciar el test cargando la primera pregunta
        testManager.start();
        
        // Guardar instancia globalmente por si necesitamos debuggear desde la consola
        window.testManager = testManager;
    }
});

