package leetcode



func maxAreaOfIsland(grid [][]int) int {

	res := 0 

	for i, row := range grid {

		for j,col := range row {
			if col == 0 {
				continue
			}
			area := areaOfIsland(grid, i, j )
			if area > res {
				res = area
			}
		}
	}
	return res
}

func isInGrid(grid [][]int, i,j int) bool {
	return i >= 0 && i < len(grid) && j >= 0 && j < len(grid[0]) && grid[i][j]==1
}

func areaOfIsland(grid [][]int, x, y int) int {
	if isInGrid(grid,x,y) {
		grid[x][y] = 0;
		return 1 + areaOfIsland(grid, 1+x,y) + areaOfIsland(grid, x-1,y) + 
				areaOfIsland(grid, x,y-1) + areaOfIsland(grid, x, y+1)
	}
	return 0
}