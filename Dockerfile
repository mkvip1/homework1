FROM ubuntu:latest
LABEL authors="ms.kuznetcov"

ENTRYPOINT ["top", "-b"]