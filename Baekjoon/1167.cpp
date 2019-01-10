#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int n;
vector<pair<int, int>> tree[100001];
bool check[100001];
int d[100001];

void bfs(int start) {
	memset(d, 0, sizeof(d));
	memset(check, false, sizeof(check));
	queue<int> q;

	check[start] = true;
	q.push(start);
	while (!q.empty()) {
		int x = q.front();
		q.pop();
		for (int i = 0; i < tree[x].size(); i++) {
			int y = tree[x][i].first;
			int cost = tree[x][i].second;

			if (!check[y]) {
				d[y] = d[x] + cost;
				q.push(y);
				check[y] = true;
			}
		}
	}
}

int main() {
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		int a;
		scanf("%d", &a);
		while (true) {
			int b, c;
			scanf("%d", &b);
			if (b == -1) break;
			scanf("%d", &c);

			tree[a].push_back(make_pair(b, c));
		}
	}

	int start = 1;
	bfs(start);
	
	for (int i = 2; i <= n; i++) {
		if (d[i] > d[start]) {
			start = i;
		}
	}

	bfs(start);
	int ans = d[1];

	for (int i = 2; i <= n; i++) {
		if (ans < d[i])
			ans = d[i];
	}
	
	printf("%d\n", ans);

	return 0;
}
