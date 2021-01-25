/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func generateTrees(n int) []*TreeNode {
	return generate(1, n)
}

func generate(left, right int) []*TreeNode {
	list := []*TreeNode{}
	if left > right {
		list = append(list, nil)
		return list
	}

	for i := left; i <= right; i++ {
		leftList := generate(left, i-1)
		rightList := generate(i+1, right)
		for _, leftnode := range leftList {
			for _, rightnode := range rightList {
				cur := &TreeNode{
					i,
					leftnode,
					rightnode,
				}
				list = append(list, cur)
			}
		}
	}

	return list
}