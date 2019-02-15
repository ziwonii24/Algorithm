#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;

const int max_dst = 123456789;
int n, m;
int s[51][51];	//도시의 정보
int d[51][51];	//치킨거리를 저장하는 배열
vector<pair<int, int>> v;	//모든 치킨집
vector<pair<int, int>> tmp;	//최대 m개의 치킨집
int ans = max_dst;

void init_d() {		//d배열 초기화
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			d[i][j] = max_dst;
}

void calc() {	
	//각 집의 치킨거리 계산
	for (int i = 0; i < tmp.size(); i++) {
		int cx = tmp[i].first;
		int cy = tmp[i].second;

		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				if (s[j][k] == 1)
					d[j][k] = min(d[j][k], abs(cx - j) + abs(cy - k));
			}
		}
	}

	//도시의 치킨거리 계산
	int sum = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (s[i][j] == 1)
				sum += d[i][j];
		}
	}
	ans = min(ans, sum);
}

void dfs(int idx) {		//m만큼의 치킨집을 고르는 경우들
	if (tmp.size() == m) {
		init_d();
		calc();
		return;
	}

	for (int i = idx; i < v.size(); i++) {
		tmp.push_back(make_pair(v[i].first, v[i].second));
		dfs(i + 1);
		tmp.pop_back();
	}
}

int main() {
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &s[i][j]);
			if (s[i][j] == 2)
				v.push_back(make_pair(i, j));
		}
	}

	dfs(0);
	printf("%d", ans);

	return 0;
}
