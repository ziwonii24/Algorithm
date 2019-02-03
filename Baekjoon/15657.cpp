#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
#include <vector>
using namespace std;

int n, m;
int a[8];
vector<int> v;

void dfs(int idx) {
	if (v.size() == m) {
		for (int i = 0; i < v.size(); i++)
			printf("%d ", v[i]);
		puts("");

		return;
	}

	for (int i = 0; i < n; i++) {
		if (v.size() == 0 || v[v.size()-1] <= a[i]) {
			v.push_back(a[i]);
			dfs(i + 1);
			v.pop_back();
		}
	}
}

int main(){
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++)
		scanf("%d", &a[i]);

	sort(a, a + n);
	dfs(0);

	return 0;
}
