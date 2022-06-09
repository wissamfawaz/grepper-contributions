"""
The below code provides an implementation
for the dijkstra's shortest path algorithm
(https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm).

Let v be the number of vertices of graph and e number of
edges in the input graph.

Time complexity: O(v^2 + e)
Space complexity: O(v)
"""


class Graph:
    def __init__(self, vertices, edges):
        self.V = vertices  # nb of vertices
        self.E = edges  # adjacency list

    # Print the lengths of shortest paths from
    # src to all the other nodes. If no path
    # is found, output would be -1.
    def print_min_dists(self, src, min_dist_list):
        print("Min distance from " + str(src) + ":")
        for vertex in range(self.V):
            print(vertex, "\t", min_dist_list[vertex])

    # Below function computes lengths of shortest paths
    # between src and all other vertices in the graph
    # using the Dijkstra's algorithm. Element at index i
    # in output list represents length of shortest path
    # from src to vertex i.
    def dijkstra(self, src):
        # Initially all distances are initialized to infinity
        min_dist_list = [float("inf")] * self.V
        min_dist_list[src] = 0
        # List of already visited nodes
        visited = set()

        # Loop until all nodes are processed
        while len(visited) != self.V:
            # The entire graph is searched for vertex having
            # min distance to source node.
            vertex, current_min_dist = self.get_vertex_min_dist(
                min_dist_list, visited)

            # If remaining nodes are not reachable, abort
            if current_min_dist == float("inf"):
                break

            # Mark current vertex as visited
            visited.add(vertex)

            # Update distances of nodes adjacent to current vertex
            for edge in self.E[vertex]:
                destination, dist_to_destination = edge
                if destination in visited:
                    continue
                new_path_dist = current_min_dist + dist_to_destination
                current_destination_dist = min_dist_list[destination]
                if new_path_dist < current_destination_dist:
                    min_dist_list[destination] = new_path_dist

        return list(map(lambda x: -1 if x == float("inf") else x, min_dist_list))

    # Get next vertex with min distance to source
    def get_vertex_min_dist(self, distances, visited):
        current_min_dist = float("inf")
        vertex = -1
        for vertex_idx, distance in enumerate(distances):
            if vertex_idx in visited:
                continue
            if distance <= current_min_dist:
                vertex = vertex_idx
                current_min_dist = distance
        return vertex, current_min_dist


vertices = 4
edges = {
    0: [(1, 2), (3, 6)],
    1: [(0, 2), (2, 2)],
    2: [(1, 2), (3, 1)],
    3: [(0, 6), (2, 1)]
}

graph = Graph(vertices, edges)
graph.print_min_dists(0, graph.dijkstra(0))
"""
Above outputs: 
Min distance from 0:
0        0
1        2
2        4
3        5
"""
