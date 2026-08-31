# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        prev = head
        curr = head.next

        pos = 1
        first_critical = -1
        prev_critical = -1

        min_distance = float('inf')
        max_distance = -1

        while curr.next:
            next_node = curr.next

            # Local maximum or local minimum
            if ((curr.val > prev.val and curr.val > next_node.val) or
                (curr.val < prev.val and curr.val < next_node.val)):

                if first_critical == -1:
                    # First critical point
                    first_critical = pos
                else:
                    # Distance from previous critical point
                    min_distance = min(
                        min_distance,
                        pos - prev_critical
                    )

                    # Distance from first critical point
                    max_distance = pos - first_critical

                prev_critical = pos

            prev = curr
            curr = next_node
            pos += 1

        if first_critical == -1 or min_distance == float('inf'):
            return [-1, -1]

        return [min_distance, max_distance]       
