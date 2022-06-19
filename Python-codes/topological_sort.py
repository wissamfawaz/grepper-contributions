"""
This implementation demonstrates how to
perform topological sort, which yields
a linear ordering of the vertices of a
graph. Example considered is that of
inter-dependent jobs.
Input: List of jobs and list of dependencies
Output: A valid order in which jobs can be
completed

Let j be the number of jobs and d the number
of dependencies.

Time complexity: O(j+d)
Space complexity: O(j+d)
"""


def topological_sort(jobs, deps):
    job_graph = create_graph(jobs, deps)
    return get_ordered_jobs(job_graph)


def create_graph(jobs, deps):
    # Create a graph of jobs
    graph = job_graph(jobs)
    # Add dependencies to every job node
    for prereq, job in deps:
        graph.add_prereq(job, prereq)
    return graph


def get_ordered_jobs(graph):
    ordered_jobs = []
    nodes = graph.nodes  # List of all job nodes
    while len(nodes):
        node = nodes.pop()
        print(node.job)
        contains_cycle = depth_first_search(node, ordered_jobs)
        # Jobs cannot be ordered in the presence of a cycle
        if contains_cycle:
            return []
    return ordered_jobs


def depth_first_search(node, ordered_jobs):
    print(node.job)
    if node.visited:
        return False  # Node already processed
    if node.visiting:
        return True  # A cycle is detected
    node.visiting = True
    # Process all prerequisite nodes
    for prereq_node in node.prereqs:
        contains_cycle = depth_first_search(prereq_node, ordered_jobs)
        if contains_cycle:
            return True
    node.visited = True  # Mark the node as processed
    node.visiting = False  # Finished processing the node
    ordered_jobs.append(node.job)
    print(ordered_jobs)
    return False


class job_graph:
    def __init__(self, jobs):
        self.nodes = []  # List of job nodes
        self.graph = {}  # Map job idx to job node
        for job in jobs:
            self.add_node(job)

    def add_prereq(self, job, prereq):
        job_node = self.get_node(job)
        # Every node keeps track of its prerequisites
        prereq_node = self.get_node(prereq)
        job_node.prereqs.append(prereq_node)

    def add_node(self, job):
        # Update graph with a new node
        self.graph[job] = job_node(job)
        self.nodes.append(self.graph[job])

    def get_node(self, job):
        if job not in self.graph:
            self.add_node(job)
        return self.graph[job]


class job_node:
    def __init__(self, job):
        self.job = job
        self.prereqs = []
        self.visited = False  # Already processed by DFS
        self.visiting = False  # Being processed by DFS


jobs = [1, 2, 3, 4]
# In the below array, 2 is dependent on 1, 3 on 1, etc...
deps = [[1, 2], [1, 3], [3, 2], [4, 2], [4, 3]]
print(topological_sort(jobs, deps))  # [4, 1, 3, 2]
