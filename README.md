# Flipt Java Library

[![Maven Central](https://img.shields.io/maven-central/v/io.flipt/flipt-java)](https://central.sonatype.com/artifact/io.flipt/flipt-java)
![hardening](https://img.shields.io/badge/status-hardening-orange)

## Documentation

API documentation is available at <https://www.flipt.io/docs/reference/overview>.

## Status

This SDK is considered in 'hardening' status. We will try to minimize breaking changes, however there still may be breaking changes between versions without a major version update.

We recommend pinning the package version to a specific version in your `build.gradle` or `pom.xml` file. This way, you can install the same version each time without breaking changes unless you are intentionally looking for the latest version.

## Breaking Changes

### 0.2.2

Version [0.2.2](https://github.com/flipt-io/flipt-java/releases/tag/0.2.2) of this client introduced a breaking change as it requires the passing of `namespace` parameter to all methods that require it. This is to support the new namespace functionality added to [Flipt v1.20.0](https://www.flipt.io/docs/reference/overview#v1-20-0).

:warning: If you are running an older version of Flipt server (< [v1.20.0](https://github.com/flipt-io/flipt/releases/tag/v1.20.0)), you should use a pre 0.2.2 version of this client.

## Install

### Gradle

Add the dependency in your `build.gradle`:

```groovy
dependencies {
    implementation 'io.flipt-io:flipt-java:0.x.x'
}
```

### Maven

Add the dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>io.flipt</groupId>
    <artifactId>flipt-java</artifactId>
    <version>0.x.x</version>
</dependency>
```

## Usage

Check out the [sample app](sample-app/src/main/java/sample/App.java) which consumes this SDK!

```java
import com.flipt.api.FliptApiClient;
import com.flipt.api.core.Defaults;
import com.flipt.api.resources.flags.types.Flag;

public class App {
  private static final String FLIPT_URL = "http://localhost:8080";

  public static void main(String[] args) {
    String token = System.getenv("FLIPT_API_TOKEN");

    FliptApiClient fliptApiClient = FliptApiClient.builder().token(token).url(FLIPT_URL).build();

    try {
      Flag flag = fliptApiClient.flags().get(Defaults.NAMESPACE, "flag_abc123");
      System.out.println("Successfully fetched flag with id" + flag.getKey());
    } catch (Exception e) {
      System.out.println("Encountered error while getting flag" + e.getMessage());
    }
  }
}
```

### Evaluation

In [v1.24.0](https://github.com/flipt-io/flipt/releases/tag/v1.24.0) of Flipt server, we added a new set of Evaluation API endpoints to allow evaluating of both boolean and multivariate flags. This SDK supports both sets of evaluation APIs (old and new) as of [v0.2.7](https://github.com/flipt-io/flipt-java/releases/tag/0.2.7).

The previous API endpoints at `/api/v1/evaluate` have been deprecated and may be removed in a future release. We recommend using the new Evaluation API at `/evaluate/v1/` for all new projects.

For more information on the new Evaluation API, please see the [API documentation](https://www.flipt.io/docs/reference/overview#v1-24-0) or blog post on [Flipt v1.24.0](https://www.flipt.io/blog/boolean-flags-and-rollouts).

```java
    try {
      EvaluationRequest req = EvaluationRequest.builder().namespaceKey(Defaults.NAMESPACE, "flag_abc123")
          .entityId("user_123").build();

      VariantEvaluationResponse resp = fliptApiClient.evaluation().variant(req);
      System.out.println("Successfully evaluated flag with id" + resp.getFlagKey());
      System.out.println("Successfully evaluated flag with variant" + resp.getVariantKey());
    } catch (Exception e) {
      System.out.println("Encountered error while evaluating flag" + e.getMessage());
    }
```

## Contributing

While we value open-source contributions to this SDK, this library is generated programmatically. Additions made directly to this library would have to be moved over to our generation code, otherwise they would be overwritten upon the next generated release. Feel free to open a PR as a proof of concept, but know that we will not be able to merge it as-is. We suggest [opening an issue](https://github.com/flipt-io/flipt-java/issues) first to discuss with us!

On the other hand, contributions to the README are always very welcome!
