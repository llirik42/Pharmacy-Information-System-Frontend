package ru.nsu.kondrenko.model.services.drugs.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import ru.nsu.kondrenko.model.dto.Drug;
import ru.nsu.kondrenko.model.dto.StoredDrug;
import ru.nsu.kondrenko.model.dto.UsedDrug;
import ru.nsu.kondrenko.model.services.ServiceConfig;
import ru.nsu.kondrenko.model.services.drugs.DrugService;
import ru.nsu.kondrenko.model.services.drugs.exceptions.DrugServiceException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DrugServiceImpl implements DrugService {
    private final String address;
    private final int port;
    private final SimpleDateFormat simpleDateFormat;

    public DrugServiceImpl(ServiceConfig config) {
        address = config.getAddress();
        port = config.getPort();
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    @Override
    public List<Drug> getDrugs() throws DrugServiceException {
        return fetchDrugs(
                getDrugsUrl(),
                "Fetching drugs failed"
        );
    }

    @Override
    public List<UsedDrug> getPopularDrugs(int limit, Integer drugTypeId) throws DrugServiceException {
        return fetchUsedDrugs(
                getPopularDrugsUrl(limit, drugTypeId),
                "Fetching popular drugs failed"
        );
    }

    @Override
    public List<Drug> getCriticalAmountDrugs() throws DrugServiceException {
        return fetchDrugs(
                getCriticalAmountDrugsUrl(),
                "Fetching critical amount drugs failed"
        );
    }

    @Override
    public List<StoredDrug> getMinimalAmountDrugs(Integer drugTypeId) throws DrugServiceException {
        return fetchStoredDrugs(
                getMinimalAmountDrugsUrl(drugTypeId),
                "Fetching minimal amount drugs failed"
        );
    }

    @Override
    public List<UsedDrug> getUsedDrugs(Date periodStart, Date periodEnd) throws DrugServiceException {
        return fetchUsedDrugs(
                getUsedDrugsUrl(periodStart, periodEnd),
                "Fetching user drugs failed failed"
        );
    }

    private List<Drug> fetchDrugs(String url, String errorMessage) throws DrugServiceException {
        final RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Drug>>() {

                    }
            ).getBody();
        } catch (Exception exception) {
            throw new DrugServiceException(errorMessage, exception);
        }
    }

    private List<UsedDrug> fetchUsedDrugs(String url, String errorMessage) throws DrugServiceException {
        final RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<UsedDrug>>() {

                    }
            ).getBody();
        } catch (Exception exception) {
            throw new DrugServiceException(errorMessage, exception);
        }
    }

    private List<StoredDrug> fetchStoredDrugs(String url, String errorMessage) throws DrugServiceException {
        final RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<StoredDrug>>() {

                    }
            ).getBody();
        } catch (Exception exception) {
            throw new DrugServiceException(errorMessage, exception);
        }
    }

    private String getDrugsUrl() {
        return String.format("http://%s:%s/drugs/", address, port);
    }

    private String getPopularDrugsUrl(int limit, Integer drugTypeId) {
        String url = getDrugsUrl() + String.format("popular?limit=%s", limit);

        if (drugTypeId != null) {
            url = String.format("%s&drug_type_id=%s", url, drugTypeId);
        }

        return url;
    }

    private String getCriticalAmountDrugsUrl() {
        return getDrugsUrl() + "critical-amount/";
    }

    private String getMinimalAmountDrugsUrl(Integer drugTypeId) {
        String url = getDrugsUrl() + "minimal-amount";

        if (drugTypeId != null) {
            url = String.format("%s?drug_type_id=%s", url, drugTypeId);
        }

        return url;
    }

    private String getUsedDrugsUrl(Date periodStart, Date periodEnd) {
        return String.format(
                "%s%s?period_start=%s&period_end=%s",
                getDrugsUrl(),
                "used",
                simpleDateFormat.format(periodStart),
                simpleDateFormat.format(periodEnd)
        );
    }
}
