#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
using namespace std;

int n, m;
int a[500050];
int b[500050];

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d", &a[i]);

	scanf("%d", &m);
	for (int i = 0; i < m; i++)
		scanf("%d", &b[i]);

	sort(a, a + n);

	for (int i = 0; i < m; i++) {
		int ans = 0;
		int target = b[i];

		int l = 0;
		int r = n - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (target == a[mid]) {
				ans = 1;
				break;
			}
			else if (a[mid] < target) l = mid + 1;
			else r = mid - 1;
		}

		printf("%d ", ans);
	}
	printf("\n");

	return 0;
}
