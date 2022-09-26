FROM quay.io/quarkus/quarkus-micro-image:1.0
WORKDIR /work/
COPY . /work/application
RUN chmod 775 /work
EXPOSE 8083
EXPOSE 8084
EXPOSE 8090
CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]