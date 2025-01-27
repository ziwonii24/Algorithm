#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;

int n;
int s[22][22];
vector<int> vst;	//start team
vector<int> vlt;	//link team
vector<int> vss;	//start team sum list
vector<int> vls;	//link team sum list
int ssum = 0, lsum = 0;
int diff = 123456789;

void calc(int x) {
	if (vss.size() == 2) {
		ssum += s[vss[0]][vss[1]] + s[vss[1]][vss[0]];
		lsum += s[vls[0]][vls[1]] + s[vls[1]][vls[0]];
		return;
	}

	for (int i = x; i < vst.size(); i++) {
		vss.push_back(vst[i]);
		vls.push_back(vlt[i]);
		calc(i+1);
		vss.pop_back();
		vls.pop_back();
	}
}

void dfs(int x) {
	if (vst.size() == n / 2) {
		vlt.clear();
		for (int i = 1; i <= n; i++) {
			bool check = false;
			for (int j = 0; j < vst.size(); j++) {
				if (i == vst[j]) {
					check = true;
					break;
				}
			}
			if (!check)
				vlt.push_back(i);
		}

		ssum = 0; lsum = 0;
		calc(0);

		diff = min(diff, abs(ssum-lsum));

		return;
	}

	for (int i = x; i <= n; i++) {
		vst.push_back(i);
		dfs(i + 1);
		vst.pop_back();
	}
}

int main() {
	scanf("%d", &n);
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++)
			scanf("%d", &s[i][j]);

	dfs(1);

	printf("%d", diff);

	return 0;
}
