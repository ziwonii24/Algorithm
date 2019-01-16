#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
#include <cstring>
#include <string>
using namespace std;

struct A {
	int first_rank, second_rank;
	int index;
}SA[100001];

char T[100001];
int r[100001], idx[100001];
int n;

int main() {
	int i;
	for (i = 1; i <= n; i++)
		SA[i] = { T[i] - 'a', 0, i };	//선언된 순서대로 값이 들어감

	sort(SA + 1, SA + n + 1);

	for (int len = 1; len < n; len *= 2) {
		r[1] = 1;
		for (i = 2; i <= n; i++) {
			r[i] = SA[i].first_rank == SA[i - 1].first_rank &&
				SA[i].second_rank == SA[i - 1].second_rank ?
				r[i - 1] : r[i - 1] + 1;
		}
		for (i = 1; i <= n; i++) {
			idx[SA[i].index] = r[i];
		}
	}

	return 0;
}
