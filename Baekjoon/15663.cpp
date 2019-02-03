#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
#include <vector>
#include <set>
#include <string>
#include <iostream>
using namespace std;

int n, m;
int a[8];
set<vector<int>> s;
vector<int> v;
bool check[8];

void dfs() {
	if (v.size() == m) {
		s.insert(v);
		return;
	}

	for (int i = 0; i < n; i++) {
		if (!check[i]) {
			check[i] = true;
			v.push_back(a[i]);
			dfs();
			check[i] = false;
			v.pop_back();
		}
	}
}

int main() {
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++)
		scanf("%d", &a[i]);

	sort(a, a + n);
	dfs();

	for (set<vector <int>>::iterator it = s.begin(); it != s.end(); it++) {
		for (int i = 0; i < it->size(); i++)
			printf("%d ", it->at(i));
		puts("");
	}

	return 0;
}
