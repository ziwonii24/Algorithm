#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
using namespace std;

int main() {	 
	char a[5][15];
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 15; j++) {
			a[i][j] = 0;
		}
	}

	for (int i = 0; i < 5; i++) {
		scanf("%s", a[i]);
	}

	for (int j = 0; j < 15; j++) {
		for (int i = 0; i < 5; i++) {
			if ((a[i][j] >= 48 && a[i][j] <= 57) ||
				(a[i][j] >= 65 && a[i][j] <= 90) ||
				(a[i][j] >= 97 && a[i][j] <= 122))
				printf("%c", a[i][j]);
		}
	}
	
	printf("\n");

	return 0;
}
