BUILD_TYPE ?= Debug
GRADLE_ARGS ?= --build-cache --continue --console 'plain'

.PHONY: all assemble bundle clean format lint test

all: clean format lint test assemble

assemble:
	./gradlew assemble${BUILD_TYPE} ${GRADLEARGS}

bundle:
	./gradlew bundle${BUILD_TYPE} ${GRADLEARGS}

clean:
	./gradlew clean

format:
	./gradlew formatKotlin ${GRADLE_ARGS}

lint:
	./gradlew lint${BUILD_TYPE} lintKotlin detekt ${GRADLEARGS}

test:
	./gradlew test${BUILD_TYPE} --continue --console 'plain' ${GRADLEARGS}
