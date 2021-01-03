# Bellmand-Ford

### Bellmand-Ford

```java
for (int pass = 0; pass < G.V(); pass++)
       for (v = 0; v < G.V(); v++)
          for (DirectedEdge e : G.adj(v))
             relax(e);
```

- 对于dst `i` src到dst的最短路径是$V_0->V_1->...->V_i$,需要走i步，在经过第ith轮的全局relaxation(relax all edges),这条路径能够最终确定，既第i+1轮全局relaxation不会再对其进行更新
- 证明方法：induction. $V_0->V_1$满足条件，如果到达node N只需要一步的话(并不是所有与src相邻的node都是全局最短，有可能绕路回来)，第一次全局relaxation就能够将$V_0->V_1$的最短路径确认，同理，第二轮会最终确认所有需要两步到达的路径，因为$V_o->V_1->V_2$是需要两步到达，所有与src一步到达的node都已经是最短了; $V_k$也满足，则定理成立

    ![Bellmand-Ford%20bd4fc59f967947e7bf50704ef8eebadc/IMG_EE809ACDF465-1.jpeg](Bellmand-Ford%20bd4fc59f967947e7bf50704ef8eebadc/IMG_EE809ACDF465-1.jpeg)

- the worst case: 经历所有vertices才能最终到达的vertex需要走V-1步，所以Bellmand-Ford算法需要V-1轮的全局relaxation
- 如果graph中存在negative cycle，则经过V-1轮全局relaxation，第V轮relaxation仍然会对vertex的distance进行更新(negative cycle更新cycle的起始vertex，起始vertex依次更新cycle中的其它vertices)，可以用这条性质对graph进行第V轮relaxation，如果会继续更新distance,则代表图中有negative cycle

    ![Bellmand-Ford%20bd4fc59f967947e7bf50704ef8eebadc/IMG_F31F769909F7-1.jpeg](Bellmand-Ford%20bd4fc59f967947e7bf50704ef8eebadc/IMG_F31F769909F7-1.jpeg)