#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
#include <unordered_map>
using namespace std;

int main() {
	int n;
	scanf("%d", &n);
	unordered_map<int, int> um;
	for (int i = 0; i < n; i++) {
		int a;
		scanf("%d", &a);
		auto result = um.insert(make_pair(a, 1));
		if (!(result.second))
			um.find(a)->second += 1;
	}

	int m;
	scanf("%d", &m);
	for (int i = 0; i < m; i++) {
		int a;
		scanf("%d", &a);
		printf("%d ", um[a]);
	}

	return 0;
}
