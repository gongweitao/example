package com.sinosoft.one.showcase.controllers;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import com.sinosoft.one.showcase.model.ProjectRelease;
import com.sinosoft.one.showcase.model.Repository;
import com.sinosoft.one.showcase.model.Version;

/**
 * Created by bin on 14-3-4.
 */
@Path("")
public class DataController {

    @Get("webVersion")
    public Reply webVersion(Invocation inv){
        Version version = new Version();
        version.setId("one-web");
        version.setName("one-web");
        version.setRepoUrl("http://github.com/spring-projects/spring-framework");
        version.setSiteUrl(inv.getRequest().getContextPath()+"/project/doc/web");
        version.setCategory("active");
        ProjectRelease projectRelease = new ProjectRelease();
        projectRelease.setReleaseStatus("SNAPSHOT");
        projectRelease.setRefDocUrl(inv.getRequest().getContextPath()+"/project/doc");
        projectRelease.setApiDocUrl(inv.getRequest().getContextPath()+"/api/apidocs-web/index.html");
        projectRelease.setGroupId("com.sinosoft.one");
        projectRelease.setArtifactId("mvc");
        Repository repository = new Repository();
        repository.setId("spring-snapshots");
        repository.setName("Spring Snapshots");
        repository.setUrl("http://repo.spring.io/snapshot");
        repository.setSnapshotsEnabled(true);
        projectRelease.setRepository(repository);
        projectRelease.setVersion("1.0.3.BUILD-SNAPSHOT");
        projectRelease.setVersionDisplayName("1.0.3");
        projectRelease.setCurrent(true);
        projectRelease.setGeneralAvailability(false);
        projectRelease.setPreRelease(false);
        projectRelease.setSnapshot(true);
        version.getProjectReleases().add(projectRelease);
        return Replys.with(version).as(Json.class);
    }
}
