#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX_TAMANO 100

// Estructura de pila para almacenar caracteres
typedef struct {
    char elementos[MAX_TAMANO];
    int tope;
} Pila;

// Función para inicializar la pila
void inicializarPila(Pila* p) {
    p->tope = -1;
}

// Función para verificar si la pila está vacía
int estaVacia(Pila* p) {
    return p->tope == -1;
}

// Función para verificar si la pila está llena
int estaLlena(Pila* p) {
    return p->tope == MAX_TAMANO - 1;
}

// Función para insertar un elemento en la pila (push)
void push(Pila* p, char elemento) {
    if (!estaLlena(p)) {
        p->tope++;
        p->elementos[p->tope] = elemento;
    }
}

// Función para eliminar y retornar el elemento del tope de la pila (pop)
char pop(Pila* p) {
    char elemento;
    if (!estaVacia(p)) {
        elemento = p->elementos[p->tope];
        p->tope--;
        return elemento;
    }
    return '\0';
}

// Función para ver el elemento del tope sin eliminarlo
char verTope(Pila* p) {
    if (!estaVacia(p)) {
        return p->elementos[p->tope];
    }
    return '\0';
}

// Función para determinar la precedencia de un operador
int precedencia(char operador) {
    if (operador == '+' || operador == '-') {
        return 1;
    } else if (operador == '*' || operador == '/') {
        return 2;
    } else if (operador == '^') {
        return 3;
    }
    return 0;
}

// Función para convertir expresión infija a notación postfija
void convertirAPostfija(char* expresion, char* postfija) {
    Pila pila;
    int i;
    int j;
    char caracter;
    char operador;
    
    inicializarPila(&pila);
    j = 0;
    
    printf("\n=== Conversion a Notacion Postfija ===\n");
    printf("Expresion infija: %s\n", expresion);
    printf("\nProceso de conversion:\n");
    
    // Recorremos la expresión caracter por caracter
    i = 0;
    while (expresion[i] != '\0') {
        caracter = expresion[i];
        
        // Si es un espacio, lo ignoramos
        if (caracter == ' ') {
            i++;
            continue;
        }
        
        // Si es un dígito, capturamos el número completo (puede tener múltiples dígitos)
        if (isdigit(caracter)) {
            while (isdigit(expresion[i])) {
                postfija[j] = expresion[i];
                j++;
                i++;
            }
            postfija[j] = ' '; // Agregamos espacio para separar números
            j++;
            i--; // Retrocedemos porque el bucle principal avanzará
            printf("  Numero completo -> Salida\n");
        }
        // Si es un paréntesis de apertura, lo apilamos
        else if (caracter == '(' || caracter == '[') {
            push(&pila, caracter);
            printf("  '%c' -> Apilar\n", caracter);
        }
        // Si es un paréntesis de cierre, desapilamos hasta encontrar el de apertura
        else if (caracter == ')' || caracter == ']') {
            printf("  '%c' -> Desapilar hasta encontrar apertura\n", caracter);
            while (!estaVacia(&pila) && verTope(&pila) != '(' && verTope(&pila) != '[') {
                operador = pop(&pila);
                postfija[j] = operador;
                j++;
                postfija[j] = ' '; // Espacio después del operador
                j++;
                printf("    Desapilado '%c' -> Salida\n", operador);
            }
            // Eliminamos el paréntesis de apertura
            if (!estaVacia(&pila)) {
                pop(&pila);
            }
        }
        // Si es un operador
        else if (caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/') {
            printf("  Operador '%c' -> ", caracter);
            // Desapilamos operadores con mayor o igual precedencia
            while (!estaVacia(&pila) && 
                   verTope(&pila) != '(' && verTope(&pila) != '[' &&
                   precedencia(verTope(&pila)) >= precedencia(caracter)) {
                operador = pop(&pila);
                postfija[j] = operador;
                j++;
                postfija[j] = ' '; // Espacio después del operador
                j++;
                printf("Desapilar '%c' -> Salida, ", operador);
            }
            // Apilamos el operador actual
            push(&pila, caracter);
            printf("Apilar '%c'\n", caracter);
        }
        
        i++;
    }
    
    // Desapilamos todos los operadores restantes
    printf("\nDesapilar operadores restantes:\n");
    while (!estaVacia(&pila)) {
        operador = pop(&pila);
        postfija[j] = operador;
        j++;
        postfija[j] = ' '; // Espacio después del operador
        j++;
        printf("  '%c' -> Salida\n", operador);
    }
    
    postfija[j] = '\0';
}

// Función para evaluar una expresión en notación postfija
float evaluarPostfija(char* postfija) {
    Pila pila;
    int i;
    char caracter;
    float operando1;
    float operando2;
    float resultado;
    char numeroStr[20];
    int j;
    
    inicializarPila(&pila);
    
    printf("\n=== Evaluacion de Notacion Postfija ===\n");
    printf("Expresion postfija: %s\n\n", postfija);
    
    i = 0;
    while (postfija[i] != '\0') {
        caracter = postfija[i];
        
        // Si es un dígito, construimos el número completo
        if (isdigit(caracter)) {
            j = 0;
            while (isdigit(postfija[i]) || postfija[i] == '.') {
                numeroStr[j] = postfija[i];
                j++;
                i++;
            }
            numeroStr[j] = '\0';
            i--; // Retrocedemos porque el bucle principal avanzará
            
            resultado = atof(numeroStr);
            // Convertimos el número a carácter para almacenarlo en la pila
            // Nota: En una implementación real, usaríamos una pila de números
            printf("  Numero %s -> Apilar\n", numeroStr);
        }
        // Si es un operador, realizamos la operación
        else if (caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/') {
            // En una implementación real, desapilaríamos números
            // Por simplicidad, aquí mostramos el proceso
            printf("  Operador '%c' -> Desapilar 2 operandos, operar, apilar resultado\n", caracter);
        }
        
        i++;
    }
    
    // Para una evaluación real, necesitaríamos una pila de números (float)
    // Por ahora retornamos 0 como placeholder
    return 0.0;
}

// Función para evaluar correctamente la expresión postfija usando una pila de números
float evaluarPostfijaCompleta(char* postfija) {
    // Pila de números (usaremos un arreglo de floats)
    float pilaNumeros[MAX_TAMANO];
    int tope;
    int i;
    char caracter;
    float operando1;
    float operando2;
    float resultado;
    char numeroStr[20];
    int j;
    
    tope = -1;
    
    printf("\n=== Evaluacion Completa ===\n");
    
    i = 0;
    while (postfija[i] != '\0') {
        caracter = postfija[i];
        
        // Si es un espacio, lo ignoramos
        if (caracter == ' ') {
            i++;
            continue;
        }
        
        // Si es un dígito, construimos el número completo
        if (isdigit(caracter)) {
            j = 0;
            while (isdigit(postfija[i]) || postfija[i] == '.') {
                numeroStr[j] = postfija[i];
                j++;
                i++;
            }
            numeroStr[j] = '\0';
            i--;
            
            resultado = atof(numeroStr);
            tope++;
            pilaNumeros[tope] = resultado;
            printf("  Numero %s -> Apilar %.2f\n", numeroStr, resultado);
        }
        // Si es un operador, realizamos la operación
        else if (caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/') {
            if (tope >= 1) {
                operando2 = pilaNumeros[tope];
                tope--;
                operando1 = pilaNumeros[tope];
                tope--;
                
                switch (caracter) {
                    case '+':
                        resultado = operando1 + operando2;
                        break;
                    case '-':
                        resultado = operando1 - operando2;
                        break;
                    case '*':
                        resultado = operando1 * operando2;
                        break;
                    case '/':
                        if (operando2 != 0) {
                            resultado = operando1 / operando2;
                        } else {
                            printf("Error: Division por cero!\n");
                            return 0.0;
                        }
                        break;
                }
                
                tope++;
                pilaNumeros[tope] = resultado;
                printf("  Operador '%c': %.2f %c %.2f = %.2f -> Apilar\n", 
                       caracter, operando1, caracter, operando2, resultado);
            }
        }
        
        i++;
    }
    
    if (tope == 0) {
        return pilaNumeros[tope];
    }
    
    return 0.0;
}

int main() {
    char expresion[] = "(3+4)*[5*((3+7)/2)+5]";
    char postfija[MAX_TAMANO];
    float resultado;
    
    printf("=== Ejercicio 2: Notacion Postfija ===\n");
    printf("Expresion original: %s\n", expresion);
    
    // Convertimos a notación postfija
    convertirAPostfija(expresion, postfija);
    
    printf("\n=== Resultado ===\n");
    printf("Notacion postfija: %s\n", postfija);
    
    // Evaluamos la expresión postfija
    resultado = evaluarPostfijaCompleta(postfija);
    
    printf("\n=== Resultado Final ===\n");
    printf("Resultado de la expresion: %.2f\n", resultado);
    
    // Verificación manual:
    // (3+4)*[5*((3+7)/2)+5]
    // = 7 * [5 * (10/2) + 5]
    // = 7 * [5 * 5 + 5]
    // = 7 * [25 + 5]
    // = 7 * 30
    // = 210
    
    printf("\nVerificacion manual:\n");
    printf("(3+4) = 7\n");
    printf("(3+7) = 10\n");
    printf("10/2 = 5\n");
    printf("5*5 = 25\n");
    printf("25+5 = 30\n");
    printf("7*30 = 210\n");
    
    return 0;
}

