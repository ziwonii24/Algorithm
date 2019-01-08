#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
#include <vector>

int n, m;
int arr[1000010];

int Find(int a) {
	if (arr[a] == a) return a;
	return arr[a] = Find(arr[a]);
}

void Union(int a, int b) {
	int pa = Find(a);
	int pb = Find(b);
	if (pa != pb) arr[pa] = pb;
}

int main() {
	scanf("%d %d", &n, &m);

	for (int i = 0; i <= n; i++)
		arr[i] = i;

	for (int i = 0; i < m; i++) {
		int q, a, b;
		scanf("%d %d %d", &q, &a, &b);
		if (q == 0) {
			Union(a, b);
		}
		else {
			int pa = Find(a);
			int pb = Find(b);
			if (pa != pb) printf("NO\n");
			else printf("YES\n");
		}
	}

	return 0;
}
