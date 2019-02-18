#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
#include <vector>
#include <set>
using namespace std;

const int max_val = 101;
int n, k;
int arr[max_val];

int main() {
	scanf("%d %d", &n, &k);
	for (int i = 0; i < n; i++) {
		int a;
		scanf("%d", &a);
		arr[a]++;
	}

	int tmp = 0;
	for (int i = 1; i < max_val; i++) {
		if (arr[i] != 0)
			tmp = max(tmp, arr[i]);
	}

	int q = tmp / k;
	int r = tmp % k;

	int set_val = q + r;

	int ans = 0;
	for (int i = 1; i < max_val; i++) {
		if (arr[i] != 0) {
			ans += set_val * k - arr[i];
		}
	}
	
	printf("%d", ans);

	return 0;
}