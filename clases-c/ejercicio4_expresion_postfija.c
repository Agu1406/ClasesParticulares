#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX_PILA 100

// Estructura de pila para operadores
typedef struct {
    char elementos[MAX_PILA];
    int tope;
} Pila;

// Función para inicializar la pila
void inicializarPila(Pila* p) {
    p->tope = -1;
}

// Función para verificar si la pila está vacía
int pilaVacia(Pila* p) {
    return p->tope == -1;
}

// Función para verificar si la pila está llena
int pilaLlena(Pila* p) {
    return p->tope == MAX_PILA - 1;
}

// Función para agregar un elemento a la pila (push)
void push(Pila* p, char elemento) {
    if (!pilaLlena(p)) {
        p->tope++;
        p->elementos[p->tope] = elemento;
    }
}

// Función para sacar un elemento de la pila (pop)
char pop(Pila* p) {
    char elemento;
    if (!pilaVacia(p)) {
        elemento = p->elementos[p->tope];
        p->tope--;
        return elemento;
    }
    return '\0';
}

// Función para ver el elemento del tope sin sacarlo (peek)
char peek(Pila* p) {
    if (!pilaVacia(p)) {
        return p->elementos[p->tope];
    }
    return '\0';
}

// Función para determinar la precedencia de operadores
int precedencia(char operador) {
    switch (operador) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        case '^':
            return 3;
        default:
            return 0;
    }
}

// Función para convertir expresión infija a postfija
void infijaAPostfija(char* expresion, char* postfija) {
    Pila pila;
    int i;
    int j;
    char caracter;
    char operador;
    
    inicializarPila(&pila);
    j = 0;
    
    printf("=== Conversion de Infija a Postfija ===\n");
    printf("Expresion infija: %s\n\n", expresion);
    printf("Paso a paso:\n");
    
    for (i = 0; expresion[i] != '\0'; i++) {
        caracter = expresion[i];
        
        // Si es un dígito, agregarlo directamente a la salida
        if (isdigit(caracter)) {
            postfija[j] = caracter;
            j++;
            printf("Digito '%c' -> Salida\n", caracter);
        }
        // Si es un paréntesis de apertura, agregarlo a la pila
        else if (caracter == '(' || caracter == '[') {
            push(&pila, caracter);
            printf("Apertura '%c' -> Pila\n", caracter);
        }
        // Si es un paréntesis de cierre
        else if (caracter == ')' || caracter == ']') {
            printf("Cierre '%c' -> Sacar de pila hasta apertura\n", caracter);
            // Sacar operadores de la pila hasta encontrar el paréntesis de apertura
            while (!pilaVacia(&pila)) {
                operador = pop(&pila);
                if (operador == '(' || operador == '[') {
                    break;
                }
                postfija[j] = operador;
                j++;
                printf("  Sacado '%c' -> Salida\n", operador);
            }
        }
        // Si es un operador
        else if (caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/') {
            printf("Operador '%c' -> ", caracter);
            // Sacar operadores de mayor o igual precedencia
            while (!pilaVacia(&pila) && 
                   peek(&pila) != '(' && peek(&pila) != '[' &&
                   precedencia(peek(&pila)) >= precedencia(caracter)) {
                operador = pop(&pila);
                postfija[j] = operador;
                j++;
                printf("Sacar '%c' -> Salida, ", operador);
            }
            push(&pila, caracter);
            printf("Agregar '%c' a pila\n", caracter);
        }
    }
    
    // Sacar todos los operadores restantes de la pila
    printf("\nVaciar pila:\n");
    while (!pilaVacia(&pila)) {
        operador = pop(&pila);
        postfija[j] = operador;
        j++;
        printf("Sacar '%c' -> Salida\n", operador);
    }
    
    postfija[j] = '\0';
}

// Estructura de pila para números (para evaluación)
typedef struct {
    float elementos[MAX_PILA];
    int tope;
} PilaNumeros;

// Función para inicializar la pila de números
void inicializarPilaNumeros(PilaNumeros* p) {
    p->tope = -1;
}

// Función para agregar un número a la pila
void pushNumero(PilaNumeros* p, float numero) {
    if (p->tope < MAX_PILA - 1) {
        p->tope++;
        p->elementos[p->tope] = numero;
    }
}

// Función para sacar un número de la pila
float popNumero(PilaNumeros* p) {
    float numero;
    if (p->tope >= 0) {
        numero = p->elementos[p->tope];
        p->tope--;
        return numero;
    }
    return 0;
}

// Función para evaluar una expresión postfija
float evaluarPostfija(char* postfija) {
    PilaNumeros pila;
    int i;
    char caracter;
    float operando1;
    float operando2;
    float resultado;
    
    inicializarPilaNumeros(&pila);
    
    printf("\n=== Evaluacion de Expresion Postfija ===\n");
    printf("Expresion postfija: %s\n\n", postfija);
    printf("Paso a paso:\n");
    
    for (i = 0; postfija[i] != '\0'; i++) {
        caracter = postfija[i];
        
        // Si es un dígito, convertirlo a número y agregarlo a la pila
        if (isdigit(caracter)) {
            pushNumero(&pila, (float)(caracter - '0'));
            printf("Digito '%c' -> Pila: %.0f\n", caracter, (float)(caracter - '0'));
        }
        // Si es un operador, realizar la operación
        else if (caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/') {
            operando2 = popNumero(&pila);
            operando1 = popNumero(&pila);
            
            switch (caracter) {
                case '+':
                    resultado = operando1 + operando2;
                    printf("Operacion: %.0f + %.0f = %.0f -> Pila\n", operando1, operando2, resultado);
                    break;
                case '-':
                    resultado = operando1 - operando2;
                    printf("Operacion: %.0f - %.0f = %.0f -> Pila\n", operando1, operando2, resultado);
                    break;
                case '*':
                    resultado = operando1 * operando2;
                    printf("Operacion: %.0f * %.0f = %.0f -> Pila\n", operando1, operando2, resultado);
                    break;
                case '/':
                    if (operando2 != 0) {
                        resultado = operando1 / operando2;
                        printf("Operacion: %.0f / %.0f = %.0f -> Pila\n", operando1, operando2, resultado);
                    } else {
                        printf("Error: Division por cero\n");
                        return 0;
                    }
                    break;
            }
            
            pushNumero(&pila, resultado);
        }
    }
    
    resultado = popNumero(&pila);
    return resultado;
}

int main() {
    // Expresión: (3+4)*[5*((3+7)/2)+5]
    // Nota: En C usamos [] como paréntesis adicionales para el ejemplo
    char expresion[] = "(3+4)*(5*((3+7)/2)+5)";
    char postfija[200];
    float resultado;
    
    printf("========================================\n");
    printf("  CONVERSION Y EVALUACION DE EXPRESION\n");
    printf("========================================\n\n");
    printf("Expresion original: (3+4)*[5*((3+7)/2)+5]\n");
    printf("Nota: Usaremos parentesis normales para ambos tipos\n");
    printf("Expresion a procesar: %s\n\n", expresion);
    
    // Convertir a postfija
    infijaAPostfija(expresion, postfija);
    
    printf("\n========================================\n");
    printf("Expresion postfija final: %s\n", postfija);
    printf("========================================\n");
    
    // Evaluar la expresión postfija
    resultado = evaluarPostfija(postfija);
    
    printf("\n========================================\n");
    printf("RESULTADO FINAL: %.2f\n", resultado);
    printf("========================================\n");
    
    // Verificación manual:
    // (3+4) = 7
    // (3+7) = 10
    // 10/2 = 5
    // 5*5 = 25
    // 25+5 = 30
    // 7*30 = 210
    
    printf("\nVerificacion manual:\n");
    printf("(3+4) = 7\n");
    printf("(3+7) = 10\n");
    printf("10/2 = 5\n");
    printf("5*5 = 25\n");
    printf("25+5 = 30\n");
    printf("7*30 = 210\n");
    
    return 0;
}

