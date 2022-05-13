"""
TCP client that connects to TCP echo server.
The client sends a user-supplied line to 
server, which sends a capitilized version 
of line back to client.   
"""
from socket import *
# Set server name and port number
server_name = "localhost"
server_port = 12000
# Create a TCP socket using IPv4
client_socket = socket(AF_INET, SOCK_STREAM)
# Connect to TCP Echo server
client_socket.connect((server_name, server_port))
# Get message to send to server
message = input("Input sentence to send to server:")
# Convert it into bytes and send it to server
message_bytes = message.encode()
client_socket.send(message_bytes)
# Wait for server's response
modified_message = client_socket.recv(1024)
# Display it on screen and then close TCP connection
print("From server:", modified_message.decode())
client_socket.close()
