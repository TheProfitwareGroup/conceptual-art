FROM icr.io/appcafe/open-liberty:full-java11-openj9-ubi

ARG VERSION=1.0
ARG REVISION=SNAPSHOT

LABEL \
  org.opencontainers.image.authors="Sergey Sobko" \
  org.opencontainers.image.vendor="The Profitware Group" \
  org.opencontainers.image.url="local" \
  org.opencontainers.image.source="https://github.com/TheProfitwareGroup/conceptual-art" \
  org.opencontainers.image.version="$VERSION" \
  org.opencontainers.image.revision="$REVISION" \
  vendor="Open Liberty" \
  name="conceptual-art" \
  version="$VERSION-$REVISION" \
  summary="Conceptual Art is a stub web service" \
  description="This image contains stub microservice running with the Open Liberty runtime."

COPY --chown=1001:0 src/main/liberty/config/ /config/
COPY --chown=1001:0 target/*.war /config/apps/

RUN configure.sh
