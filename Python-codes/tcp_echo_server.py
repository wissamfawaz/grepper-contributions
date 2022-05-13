"""
TCP echo server that converts a message
received from client into uppercase and
then sends it back to client. 
"""
from socket import *
# Port number of server
server_port = 12000
# Server using IPv4 and TCP socket
server_socket = socket(AF_INET, SOCK_STREAM)
# Bind server to port number and IP address
server_socket.bind(("127.0.0.1", server_port))
# server_socket is a welcoming socket/door
# Parameter specifies the max nb of queued requests
server_socket.listen(1)
print("The server is ready to receive msgs...")
while True:
    # TCP connection establishment phase:
    # When client knocks on the door, create a
    # connection socket dedicated to client
    connection_socket, addr = server_socket.accept()
    # Data transfer phase
    sentence = connection_socket.recv(1024).decode()
    capitilized_sentence = sentence.upper()
    connection_socket.send(capitilized_sentence.encode())
    # TCP connection termination phase
    connection_socket.close()
