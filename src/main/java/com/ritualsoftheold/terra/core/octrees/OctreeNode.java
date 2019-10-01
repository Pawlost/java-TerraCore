package com.ritualsoftheold.terra.core.octrees;

/*
 *   New Octree definition. Basic Node for a linear octree
 */
public class OctreeNode implements OctreeBase {
    private float worldX;
    private float worldY;
    private float worldZ;

    private int halfSize = 0;

    private OctreeBase[] children;

    public OctreeNode(boolean isLeaf) {
        children = new OctreeBase[]{null, null, null, null, null, null, null, null};
    }

    public OctreeNode() {
        this(true);
    }

    public void setChildren(OctreeBase c1, OctreeBase c2, OctreeBase c3, OctreeBase c4, OctreeBase c5, OctreeBase c6, OctreeBase c7, OctreeBase c8) {
        this.children[0] = c1;
        this.children[1] = c2;
        this.children[2] = c3;
        this.children[3] = c4;
        this.children[4] = c5;
        this.children[5] = c6;
        this.children[6] = c7;
        this.children[7] = c8;
        calculateCenter();
    }

    private void calculateCenter() {
        for (int i = 0; i < 8; i++) {
            if (children[i] instanceof OctreeLeaf) {
                OctreeLeaf leaf = (OctreeLeaf) children[i];
                this.worldX += leaf.worldX;
                this.worldY += leaf.worldY;
                this.worldZ += leaf.worldZ;
                halfSize += 4;
            } else {
                OctreeNode child = (OctreeNode) children[i];
                this.worldX += child.worldX;
                this.worldY += child.worldY;
                this.worldZ += child.worldZ;
                int halfSizemore = child.halfSize >> 1;
                halfSize += halfSizemore;
            }
        }

        halfSize = halfSize / 2;
        this.worldX /= 8;
        this.worldY /= 8;
        this.worldZ /= 8;
    }
}
