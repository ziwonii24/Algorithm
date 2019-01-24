#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
using namespace std;

int main() {
	int n;
	scanf("%d", &n);

	int sum = 1;
	int i = 6;
	while(1) {
		if (n <= sum) {
			printf("%d\n", i / 6);
			break;
		}
		sum += i;
		i += 6;
	}

	return 0;
}
