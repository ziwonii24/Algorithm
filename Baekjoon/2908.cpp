#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
using namespace std;

int main() {
	int a, b;
	scanf("%d %d", &a, &b);

	int aa=0, bb=0;
	for (int i = 100; i >= 1; i/=10) {
		aa += a % 10 * i;
		bb += b % 10 * i;
		a /= 10; 
		b /= 10;
	}

	if (aa < bb)
		printf("%d\n", bb);
	else
		printf("%d\n", aa);

	return 0;
}
