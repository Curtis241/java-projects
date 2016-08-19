
vi /etc/hosts

127.0.0.1   calorietracker


Add the following iptables rules to forward port 8080 to 80.

iptables -t nat -A PREROUTING -p tcp --dport 80 -j REDIRECT --to-port 8080
if you need to use localhost also add this

iptables -t nat -I OUTPUT -p tcp -d 127.0.0.1 --dport 80 -j REDIRECT --to-ports 8080


Delete the following

sudo iptables -t nat -n -L

sudo iptables -t nat -D OUTPUT 1
sudo iptables -t nat -D PREROUTING 2
