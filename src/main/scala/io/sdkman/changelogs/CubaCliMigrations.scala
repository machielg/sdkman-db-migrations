package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "014")
class CubaCliMigrations {

  @ChangeSet(order = "001", id = "001_add_cubacli_candidate", author = "jreznot")
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "cuba-cli",
      name = "CUBA CLI",
      description = "CUBA CLI is an open source command line utility that enables you to easily create projects based on CUBA Platform",
      websiteUrl = "https://cuba-platform.com",
      distribution = "PLATFORM_SPECIFIC"
    ).insert()

    List(
      Version(
        candidate = "cuba-cli",
        version = "1.0.1",
        url = "https://cuba-platform.bintray.com/tools/cuba-cli/1.0.1/cuba-cli-1.0.1-linux.zip",
        platform = Linux64
      ),
      Version(
        candidate = "cuba-cli",
        version = "1.0.1",
        url = "https://cuba-platform.bintray.com/tools/cuba-cli/1.0.1/cuba-cli-1.0.1-macos.zip",
        platform = MacOSX
      ),
      Version(
        candidate = "cuba-cli",
        version = "1.0.1",
        url = "https://cuba-platform.bintray.com/tools/cuba-cli/1.0.1/cuba-cli-1.0.1-windows.zip",
        platform = Windows
      ))
      .validate()
      .insert()
  }
}