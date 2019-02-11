#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
#include <queue>
using namespace std;

int n, k;
queue<int> q;
int visited[100001];

int bfs() {
	q.push(n);
	visited[n] = 1;

	while (!q.empty()) {
		int x = q.front();
		q.pop();

		if (x == k)
			return visited[x] - 1;

		if (visited[x-1] == 0 && x - 1 >= 0) {
			visited[x - 1] = visited[x] + 1;
			q.push(x - 1);
		}
		if (visited[x + 1] == 0 && x + 1 <= 100000) {
			visited[x + 1] = visited[x] + 1;
			q.push(x + 1);
		}
		if (visited[2 * x] == 0 && 2 * x <= 100000) {
			visited[2 * x] = visited[x] + 1;
			q.push(2 * x);
		}
	}
}

int main() {
	scanf("%d %d", &n, &k);
	printf("%d", bfs());

	return 0;
}
