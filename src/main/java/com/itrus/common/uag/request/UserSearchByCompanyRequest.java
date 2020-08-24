package com.itrus.common.uag.request;

;
import com.itrus.common.uag.request.base.SearchBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSearchByCompanyRequest  extends SearchBase {
    /**
     *企业唯一标识
     */
    private Long companyUuid;
}
