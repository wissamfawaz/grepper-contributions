from socket import *
# Set server name and port number
server_name = "localhost"
server_port = 12000
# Create a UDP socket using IPv4
client_socket = socket(AF_INET, SOCK_DGRAM)
# Get message to send to server
message = input("Input sentence to send to server:")
# Convert it into bytes
message_bytes = bytes(message, encoding='utf-8')
client_socket.sendto(message_bytes, (server_name, server_port))
# Wait for server's response
modified_message, server_address = client_socket.recvfrom(2048)
# Display it on screen
print(modified_message.decode("utf-8"))
client_socket.close()
