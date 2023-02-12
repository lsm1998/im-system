package com.lsm1998.im.imadmin.internal.base.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiteInfoResponse
{
    private SiteInfo site;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SiteInfo
    {
        private String siteName;
        private String recordNumber;
        private String version;
        private String cdnUrl;
        private Upload upload;
        private boolean openMemberCenter;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Upload
    {
        private long maxsize;
        private String savename;
        private String mimetype;
        private String mode;
    }
}
