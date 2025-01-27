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

	int tc;
	cin >> tc;
	while (tc--) {
		int n, m, cnt=0;
		queue<pair<int, int>> q;
		priority_queue<int> pq;

		cin >> n >> m;
		for (int i = 0; i < n; i++) {
			int a;
			cin >> a;
			q.push({ i,a });
			pq.push(a);
		}

		while (!q.empty()) {
			int nowidx = q.front().first;
			int nowval = q.front().second;
			q.pop();

			if (pq.top() == nowval) {
				pq.pop();
				cnt++;
				if (nowidx == m) {
					cout << cnt << '\n';
					break;
				}
			}
			else
				q.push({ nowidx,nowval });
		}		
	}

	return 0;
}
