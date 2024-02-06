# Application layer
FROM adoptopenjdk/openjdk21:jre-21.0.19_7 AS applicationImage

COPY deployfolder .
COPY bin/run_tax_center.sh run.sh

RUN chmod u+x run.sh

ARG APP_ENV
ENV APP_ENV=$APP_ENV

# TODO: Make the exposed Port Dynamic from ENV
EXPOSE 9000

ENTRYPOINT ./run.sh ${APP_ENV:-dev} ${ATTACH_DD:-false}