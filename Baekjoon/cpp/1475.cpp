#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
using namespace std;

const int max_val = 1000000;
char n[max_val + 1];
int num[10];

int main() {
	for (int i = 0; i < 10; i++)
		num[i] = 0;

	scanf("%s", &n);
	
	for (int i = 0; i < max_val; i++) {
		if (n[i] == 0) break;
		if (n[i]-'0' == 9) num[6]++;
		else num[n[i]-'0']++;
	}

	if (num[6] % 2 == 0) num[6] /= 2;
	else num[6] = num[6] / 2 + 1;

	int ans = 0;
	for (int i = 0; i < 9; i++)
		ans = max(ans, num[i]);
	
	printf("%d\n", ans);

	return 0;
}
