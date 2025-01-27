#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <vector>
#include <algorithm>
#include <functional>
using namespace std;

int n, m;
int a[100010];
int b[100010];

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d", &a[i]);

	sort(a, a + n);

	scanf("%d", &m);
	for (int i = 0; i < m; i++)
		scanf("%d", &b[i]);

	for (int i = 0; i < m; i++) {
		int ans = 0;
		int target = b[i];

		int l = 0;
		int r = n - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (a[mid] < target) l = mid + 1; 
			else if (target < a[mid]) r = mid - 1;
			else if (target == a[mid]) {
				ans = 1;
				break;
			}
		}

		printf("%d\n", ans);
	}
	
	
	return 0;
}
