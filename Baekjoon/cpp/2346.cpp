#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
#include <deque>
using namespace std;

int main() {
	int n;
	scanf("%d", &n);
	deque<pair<int, int>> d;
	for (int i = 0; i < n; i++) {
		int a;
		scanf("%d", &a);
		d.push_back(make_pair(i+1, a));
	}

	int val = d.front().second;
	printf("%d ", d.front().first);
	d.pop_front();
	while (!d.empty()) {
		if (val > 0) {
			for (int i = 0; i < val; i++) {
				d.push_back(make_pair(d.front().first, d.front().second));
				d.pop_front();
			}
			val = d.back().second;
			printf("%d ", d.back().first);
			d.pop_back();
		}
		else {
			for (int i = 0; i < abs(val); i++) {
				d.push_front(make_pair(d.back().first, d.back().second));
				d.pop_back();
			}
			val = d.front().second;
			printf("%d ", d.front().first);
			d.pop_front();
		}
	}

	return 0;
}
