FROM maven:3.6.3-jdk-8
RUN apt-get update
RUN apt-get install git -y
RUN git clone https://github.com/PressF5/Rick_and_Morty_Demo.git
WORKDIR /Rick_and_Morty_Demo