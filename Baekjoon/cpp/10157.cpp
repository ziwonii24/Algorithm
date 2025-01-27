#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
using namespace std;

int c, r, k;
bool check[1001][1001];
int cnt = 0;

void search(int x, int y, int pos) {
	// pos = 0: up, 1: down, 2: left, 3: right
	check[x][y] = true;
	cnt++;
	if (cnt == k) {
		printf("%d %d\n", x, y);
		return;
	}
	int nx, ny;
	switch (pos) {
	case 0:	//up
		nx = x; ny = y + 1;
		if (ny <= r) {
			if (!check[nx][ny]) 
				search(nx, ny, 0);
			else {
				if (!check[nx + 1][ny - 1])
					search(++nx, --ny, 3);
				else return;
			}
		}
		else {
			if (!check[nx+1][ny-1]) 
				search(++nx, --ny, 3);
		}
		break;
	case 1:	//down
		nx = x; ny = y - 1;
		if (ny >= 1) {
			if (!check[nx][ny])
				search(nx, ny, 1);
			else {
				if (!check[nx - 1][ny + 1])
					search(--nx, ++ny, 2);
				else return;
			}
		}
		else {
			if (!check[nx-1][ny+1])
				search(--nx, ++ny, 2);
		}
		break;
	case 2:	//left
		nx = x-1; ny = y;
		if (nx > 1) {
			if (!check[nx][ny])
				search(nx, ny, 2);
			else {
				if (!check[nx + 1][ny + 1])
					search(++nx, ++ny, 0);
				else return;
			}
		}
		else {
			if (!check[nx + 1][ny + 1])
				search(++nx, ++ny, 0);
		}
		break;
	case 3:	//right
		nx = x+1; ny = y;
		if (nx <= c) {
			if (!check[nx][ny])
				search(nx, ny, 3);
			else {
				if (!check[nx - 1][ny - 1])
					search(--nx, --ny, 1);
				else return;
			}
		}
		else {
			if (!check[nx - 1][ny - 1])
				search(--nx, --ny, 1);
		}
		break;
	}
}

int main(){
	scanf("%d %d", &c, &r);
	scanf("%d", &k);

	if (c*r < k) {
		printf("0\n");
		return 0;
	}

	for (int i = 1; i <= c; i++) {
		for (int j = 1; j <= r; j++) {
			check[i][j] = false;
		}
	}

	search(1, 1, 0);

	return 0;
}
