FROM quay.io/quarkus/quarkus-micro-image:1.0
WORKDIR /work/
COPY . /work/application
RUN chmod 775 /work
EXPOSE 9000
#/bin
#CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]
CMD ["tail", "-f", "/dev/null"]

