#include <iostream>
#include <cstdio>
#include <queue>
#include <algorithm>
#include <string>
#include <cstring>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n, m;
	cin >> n >> m;

	queue<int> q;
	for (int i = 0; i < n; i++)
		q.push(i + 1);

	printf("<");
	while(!q.empty()) {
		for (int i = 0; i < m - 1; i++) {
			q.push(q.front());
			q.pop();
		}
		if (q.front() == q.back())
			printf("%d>\n", q.front());
		else
			printf("%d, ", q.front());
		q.pop();
	}

	return 0;
}
