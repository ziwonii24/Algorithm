#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
#include <vector>
using namespace std;

const int max_val = 100001;
int n;
int a[max_val];
long double d[max_val];

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d", &a[i]);

	double tmp = 0;
	int ans = 0;
	for (int i = 0; i < n; i++) {
		d[i] = a[i];
		for (int j = i + 1; j < n; j++) {
			d[j] = d[j - 1] + a[j];
		}

		for (int j = i; j < n; j++) {
			d[j] = d[j] / (j - i + 1);
			if (tmp <= d[j]) {
				tmp = d[j];
				ans = max(ans, j - i + 1);
			}
		}
	}

	printf("%d", ans);

	return 0;
}
