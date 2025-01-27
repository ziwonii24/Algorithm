#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
using namespace std;

int main(){
	int tc;
	scanf("%d", &tc);
	while (tc--) {
		int n, m, a[1000001], b;
		scanf("%d", &n);
		for (int i = 0; i < n; i++)
			scanf("%d", &a[i]);

		sort(a, a + n);

		scanf("%d", &m);
		for (int i = 0; i < m; i++) {
			scanf("%d", &b);
			if (binary_search(a, a + n, b))
				puts("1");
			else
				puts("0");
		}
	}

	return 0;
}
