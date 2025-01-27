#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
using namespace std;

int main() {
	int day, car;
	scanf("%d", &day);

	int cnt = 0;
	for (int i = 0; i < 5; i++) {
		scanf("%d", &car);
		if (car == day) cnt++;
	}

	printf("%d\n", cnt);

	return 0;
}
