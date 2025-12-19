import java.util.*;

class Solution {

    static final char EMPTY = '.';
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public int solution(String[] storage, String[] requests) {

        int H = storage.length;
        int W = storage[0].length();

        // =========================
        // 1️⃣ 패딩 적용
        // =========================
        char[][] map = new char[H + 2][W + 2];

        // 전체를 EMPTY로 초기화 (외부 공간)
        for (int i = 0; i < H + 2; i++) {
            Arrays.fill(map[i], EMPTY);
        }

        // 실제 storage 복사 (1,1)부터 시작
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map[i + 1][j + 1] = storage[i].charAt(j);
            }
        }

        int PH = H + 2;
        int PW = W + 2;

        // =========================
        // 2️⃣ 요청 처리
        // =========================
        for (String req : requests) {
            char target = req.charAt(0);

            // ---------- 크레인 ----------
            if (req.length() == 2) {
                for (int i = 1; i <= H; i++) {
                    for (int j = 1; j <= W; j++) {
                        if (map[i][j] == target) {
                            map[i][j] = EMPTY;
                        }
                    }
                }
            }

            // ---------- 지게차 ----------
            else {
                boolean[][] visited = new boolean[PH][PW];
                Queue<int[]> queue = new ArrayDeque<>();

                // 항상 (0,0)에서 시작 = 외부
                visited[0][0] = true;
                queue.offer(new int[]{0, 0});

                // 2-1. 외부와 연결된 모든 빈 공간 BFS
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int x = cur[0], y = cur[1];

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (nx < 0 || ny < 0 || nx >= PH || ny >= PW) continue;
                        if (visited[nx][ny]) continue;
                        if (map[nx][ny] != EMPTY) continue;

                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }

                // 2-2. 제거 대상 컨테이너 수집
                List<int[]> toRemove = new ArrayList<>();

                for (int i = 1; i <= H; i++) {
                    for (int j = 1; j <= W; j++) {
                        if (map[i][j] != target) continue;

                        for (int d = 0; d < 4; d++) {
                            int ni = i + dx[d];
                            int nj = j + dy[d];

                            if (visited[ni][nj]) {
                                toRemove.add(new int[]{i, j});
                                break;
                            }
                        }
                    }
                }

                // 2-3. 실제 제거
                for (int[] pos : toRemove) {
                    map[pos[0]][pos[1]] = EMPTY;
                }
            }
        }

        // =========================
        // 3️⃣ 남은 컨테이너 개수 계산
        // =========================
        int answer = 0;
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                if (map[i][j] != EMPTY) {
                    answer++;
                }
            }
        }

        return answer;
    }
}