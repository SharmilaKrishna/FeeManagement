/*
 * package com.fees.service.impl;
 * 
 * import static org.junit.jupiter.api.Assertions.assertNotNull; import static
 * org.junit.jupiter.api.Assertions.assertThrows; import static
 * org.mockito.ArgumentMatchers.any; import static
 * org.mockito.ArgumentMatchers.anyString; import static
 * org.mockito.Mockito.when;
 * 
 * import java.math.BigDecimal; import java.util.Collections; import
 * java.util.Date;
 * 
 * import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;
 * import org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.mockito.MockitoAnnotations; import
 * org.springframework.web.client.RestTemplate;
 * 
 * import com.fees.dto.FeesDto; import com.fees.dto.ItemDto; import
 * com.fees.entity.Fees; import com.fees.entity.Receipt; import
 * com.fees.entity.Student; import com.fees.repository.FeeRepository; import
 * com.fees.repository.ItemDetailRepository; import
 * com.fees.repository.ReceiptRepository; import
 * com.fees.service.impl.FeeServiceImpl;
 * 
 * public class FeeServiceImplTest {
 * 
 * @Mock private FeeRepository feeRepository;
 * 
 * @Mock private ReceiptRepository receiptRepository;
 * 
 * @Mock private ItemDetailRepository itemDetailRepository;
 * 
 * @Mock private RestTemplate restTemplate;
 * 
 * @InjectMocks private FeeServiceImpl feeService;
 * 
 * @BeforeEach public void setUp() { MockitoAnnotations.initMocks(this); }
 * 
 * @Test public void testCreateFeeAndReceipt_Success() { // Mock data FeesDto
 * feesDto = new FeesDto(1L, new BigDecimal("100.00"), new Date(), "Paid",
 * "John Doe", "REF123", "1234567890", "Visa", 1L);
 * 
 * 
 * Student student = new Student(); student.setId(1L);
 * student.setName("John Doe");
 * 
 * when(restTemplate.getForObject(anyString(), any())).thenReturn(student); Fees
 * mockFees = mock(Fees.class);
 * when(feeRepository.save(any())).thenReturn(mockFees);
 * 
 * when(receiptRepository.save(any())).thenReturn(new Receipt());
 * 
 * // Test Fees result = feeService.createFeeAndReceipt(feesDto);
 * 
 * // Verify assertNotNull(result); }
 * 
 * @Test public void testCreateFeeAndReceipt_NullFeesDto() { // Test and verify
 * assertThrows(IllegalArgumentException.class, () ->
 * feeService.createFeeAndReceipt(null)); }
 * 
 * // Add more test cases for other scenarios as needed...
 * 
 * }
 */