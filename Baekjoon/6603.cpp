#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
using namespace std;

const int max_len = 13;
int k, a[max_len];
bool check[max_len];
int ans[max_len];

void dfs(int h, int x) {
	if (h == 6) {
		for (int i = 0; i < 6; i++)
			printf("%d ", ans[i]);
		printf("\n");
		return;
	}

	for (int i = x; i < k; i++) {
		ans[h] = a[i];
		dfs(h + 1, i + 1);
	}
}

int main() {
	while (1) {
		for (int i = 0; i < max_len; i++) {
			a[i] = 0;
			check[i] = false;
		}

		scanf("%d", &k);
		if (k == 0) return 0;

		for (int i = 0; i < k; i++)
			scanf("%d", &a[i]);

		dfs(0, 0);
		printf("\n");
	}
	return 0;
}
