package src.shape.point;
/**
 * Package Name : src.shape.point;
 * File name : PointOnSegment;
 * Creator: Kane;
 * Date: 9/13/20
 */

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class PointOnSegment {

    public boolean onSegment(Point p, Point q, Point r) {
        if (q.x >= Math.min(p.x, r.x) && q.x <= Math.min(p.x, r.x) && q.y >= Math.min(p.y, r.y) && q.y <= Math.min(p.y, r.y)) {
            return true;
        }
        return false;

    }
    public boolean pointOnSegment(Point C, Point A, Point B) {
        Point AC = new Point(C.x - A.x, C.y - A.y);
        Point BC = new Point(C.x - B.x, C.y - B.y);
        int res = AC.x * BC.y - AC.y * BC.x;
        return res == 0 && onSegment(A, B, C);

    }
}
