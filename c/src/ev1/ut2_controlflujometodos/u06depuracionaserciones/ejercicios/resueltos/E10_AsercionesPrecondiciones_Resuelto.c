/*
E10 - Anade aserciones (RESUELTO)

ENUNCIADO:
  Anade con assert las precondiciones y postcondiciones indicadas:
    raiz_entera(n): precondicion n >= 0; postcondicion r*r <= n < (r+1)*(r+1).
    media_de(v, n): precondiciones v != NULL y n > 0.

PISTA:
  assert(condicion) de <assert.h>

SOLUCION:
  Todas las pruebas deben mostrar OK.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <assert.h>

static int pruebas = 0;
static int aciertos = 0;
#define PRUEBA(cond) do { pruebas++; if (cond) { aciertos++; printf("  [ OK  ] %s\n", #cond); } \
                          else { printf("  [FALLO] %s\n", #cond); } } while (0)


int raiz_entera(int n) {
    assert(n >= 0);
    int r = 0;
    while ((r + 1) * (r + 1) <= n) {
        r++;
    }
    assert(r * r <= n && n < (r + 1) * (r + 1));
    return r;
}

double media_de(const int *v, int n) {
    assert(v != NULL);
    assert(n > 0);
    int suma = 0;
    for (int i = 0; i < n; i++) {
        suma += v[i];
    }
    return (double)suma / n;
}

int main(void) {
    int datos[] = {2, 4, 6, 8};
    PRUEBA(raiz_entera(0) == 0);
    PRUEBA(raiz_entera(50) == 7);
    PRUEBA(raiz_entera(49) == 7);
    PRUEBA(media_de(datos, 4) == 5.0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
